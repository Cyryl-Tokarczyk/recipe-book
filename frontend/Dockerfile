FROM nginx

COPY dist/frontend /usr/share/nginx/html/
COPY docker/etc/nginx/templates/ /etc/nginx/templates/

EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]