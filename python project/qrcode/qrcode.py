import qrcode as qrcode

input_data = "https://google.com"  # url to encode 
qr = qrcode.QRCode(
        version=1,
        box_size=10,
        border=5)
qr.add_data(input_data)
qr.make(fit=True)
img = qr.make_image(fill='black', back_color='white')
img.save('qrcode002.png')  #save image as qrcode002.png in directory 