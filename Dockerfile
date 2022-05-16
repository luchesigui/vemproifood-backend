FROM node:7-alpine

# Create app directory
WORKDIR /usr/src/app

# Install app dependencies
COPY . .
# For npm@5 or later, copy package-lock.json as well
# COPY package.json package-lock.json .

RUN npm install --no-optional

#RUN npm run build

EXPOSE 3000

CMD [ "npm", "start" ]

