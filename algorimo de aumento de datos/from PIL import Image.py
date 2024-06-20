from PIL import Image
from PIL import ImageEnhance
from PIL import ImageOps
from PIL import ImageFilter
import random

def resize_image(image_path, output_size=(640, 640)):
    image = Image.open(image_path)
    image = image.resize(output_size)
    return image.convert('RGB')  # Convertir la imagen al modo RGB

def save_image(image, output_path):
    image.save(output_path)

def random_zoom(image):
    # Generar un factor de zoom aleatorio entre 0.8 y 1.2
    zoom_factor = random.uniform(0.8, 1.2)
    
    # Calcular el tamaño de la región aleatoria
    width, height = image.size
    new_width = int(width * zoom_factor)
    new_height = int(height * zoom_factor)
    
    # Seleccionar una región aleatoria de la imagen
    left = random.randint(0, width - new_width)
    top = random.randint(0, height - new_height)
    right = left + new_width
    bottom = top + new_height
    region = (left, top, right, bottom)
    
    # Recortar y redimensionar la región seleccionada para que sea del mismo tamaño que la imagen original
    zoomed_image = image.crop(region).resize(image.size)
    
    return zoomed_image

def random_rotation(image):
    angle = random.randint(0, 360)  # Rotar la imagen en un ángulo aleatorio entre 0 y 360 grados
    return image.rotate(angle)

# Generar imágenes adicionales con diferentes transformaciones
def generate_images(image):
    images = []
    
    # Agregar la imagen original
    images.append(image)
    
    # Rotar 90 grados
    images.append(image.rotate(90))

    # Espejo horizontal
    images.append(ImageOps.mirror(image))
     
    # Espejo vertical
    images.append(ImageOps.flip(image))
    
    # Aumento de contraste
    enhancer = ImageEnhance.Contrast(image)
    images.append(enhancer.enhance(1.5))
    
    # Aumento de brillo
    enhancer = ImageEnhance.Brightness(image)
    images.append(enhancer.enhance(1.6))
    
    # Reducción de contraste
    enhancer = ImageEnhance.Contrast(image)
    images.append(enhancer.enhance(0.5))
    
        # Rotación aleatoria
    images.append(random_rotation(image))

    # Desenfoque
    images.append(image.filter(ImageFilter.BLUR))
    
    # Zoom aleatorio
    images.append(random_zoom(image))
    
    return images


if __name__ == "_main_":
    # Ruta de la imagen original
    original_image_path = "1 (14).png"  # Reemplaza esta ruta con la ruta de tu imagen original
    
    # Redimensionar la imagen original
    resized_image = resize_image(original_image_path)
    
    # Guardar la imagen redimensionada
    #save_image(resized_image,"C:/Users/bryan/OneDrive/Escritorio/nov/1.jpg")  # Reemplaza esta ruta con la ruta donde deseas guardar la imagen redimensionada
    
    # Generar imágenes adicionales con diferentes transformaciones
    transformed_images = generate_images(resized_image)
    
    # Guardar las imágenes transformadas
    for i, image in enumerate(transformed_images):
        save_image(image, f"C:/Users/bryan/OneDrive/Escritorio/nov/20_{i+1}.jpg")  # Reemplaza esta ruta con la ruta donde deseas guardar las imágenes transformadas