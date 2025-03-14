FROM node:22 AS build

WORKDIR /app

COPY package*.json ./

RUN npm install

COPY . .

RUN npm run build

FROM nginx

COPY --from=build /app/dist/frontend /usr/share/nginx/html/
COPY docker/etc/nginx/templates/ /etc/nginx/templates/

EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]