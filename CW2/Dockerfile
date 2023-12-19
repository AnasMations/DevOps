# Use Node.js
FROM node:14

# Set the working directory in the container
WORKDIR /usr/src/app

# Copy package.json and package-lock.json to the working directory
COPY package*.json ./

# Install npm
RUN npm install

COPY . .

# Expose the port on which the app will run on 8080
EXPOSE 8080

# Define environment variable
ENV HOSTNAME="localhost"

# CMD run app
CMD ["node", "server.js"]

