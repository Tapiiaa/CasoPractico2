# Usa una imagen base de Node.js
FROM node:14

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia los archivos de dependencias
COPY package*.json ./

# Instala las dependencias de Node.js
RUN npm install

# Copia el código de la aplicación
COPY . .

# Expone el puerto en el que correrá la aplicación frontend
EXPOSE 3000

# Comando para ejecutar la aplicación
CMD ["npm", "start"]
