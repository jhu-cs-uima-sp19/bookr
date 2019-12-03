import requests

#Scraping the maps from amazonaws

#All the URLs for maps
data = [
    'https://libapps.s3.amazonaws.com/customers/3/images/BLC1030.jpg',
    'https://libapps.s3.amazonaws.com/customers/3/images/BLC1031.jpg',
    'https://libapps.s3.amazonaws.com/customers/3/images/BLC2003.jpg',
    'https://libapps.s3.amazonaws.com/customers/3/images/BLC2005.jpg',
    'https://libapps.s3.amazonaws.com/customers/3/images/BLC2006.jpg',
    'https://libapps.s3.amazonaws.com/customers/3/images/BLC2007.jpg',
    'https://libapps.s3.amazonaws.com/customers/3/images/BLC2010.jpg',
    'https://libapps.s3.amazonaws.com/customers/3/images/BLC3010.jpg',
    'https://libapps.s3.amazonaws.com/customers/3/images/BLC4031.jpg',
    'https://libapps.s3.amazonaws.com/customers/3/images/BLC4043.jpg',
    'https://libapps.s3.amazonaws.com/customers/3/images/BLC4045.jpg',
    'https://libapps.s3.amazonaws.com/customers/3/images/BLC4047.jpg',
    'https://libapps.s3.amazonaws.com/customers/3/images/BLC4049.jpg',
    'https://libapps.s3.amazonaws.com/customers/3/images/BLC4051.jpg',
    'https://libapps.s3.amazonaws.com/customers/3/images/BLC4053.jpg',
    'https://libapps.s3.amazonaws.com/customers/3/images/BLC5010.jpg',
]

#a loop that downloads all the maps and naming each as BLC + Room Number

for d in data:
    path = d.split('/')[-1]
    r = requests.get(d)
    with open(path, 'wb') as f:
        f.write(r.content)
