import boto3
import csv
from PIL import Image, ImageDraw, ImageFont
import io

#read the secret.csv file that contains the key id and access key 
with open('secret.csv', 'r') as file :
    next(file)
    reader =csv.reader(file)
    
    
    for line in reader:
        access_key_id  =line[0]
        secret_access_key =line[1]
        
  # connect to the aws rekognitoon with the credentials and assign to variable client    
client = boto3.client('rekognition',region_name = 'us-west-2', aws_access_key_id = access_key_id, aws_secret_access_key = secret_access_key)

#replace with the desire path to the image you want to run the script on 
photo ='people.jpg'

with open(photo,'rb') as image_file :
    source_bytes = image_file.read()
    
    
detect_objects = client.detect_labels(Image={'Bytes' : source_bytes})

image = Image.open(io.BytesIO(source_bytes))
draw = ImageDraw.Draw(image)
 
for label in detect_objects['Labels']:
    print(label['Name'] )
    print('Confidence', label['Confidence'])
    
    
    for instances in label['Instances']:
        if 'BoundingBox' in instances:
            
            box= instances['BoundingBox']
            
            left = image.width * box['Left']
            top = image.height * box['Top']
            width = image.width * box['Width']
            height = image.width * box['Height']
            
            points=(
                (left,top),
                (left+width, top ),
                (left+width, top+height),
                (left, top +height),
                (left,top)            

                
                )
            draw.line(points, width=5, fill ='#69f5d9')
            
            shape = [(left - 2, top - 35), (width + 2 + left, top )]
            draw.rectangle(shape, fill='#69f5d9')
            font = ImageFont.truetype('sketch.ttf', 30)
            name = label['Name']+ ' ' + str(int(label['Confidence']))
            draw.text((left + 10, top - 30), name, font=font, fill='#000000')
            
image.show()