FROM node:slim
WORKDIR /express
COPY package*.json ./
COPY . .
CMD ["node", "express.cjs"]
EXPOSE 9090