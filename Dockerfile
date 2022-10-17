FROM tomcat:latest
ADD out/artifacts/todoList_war_exploded /usr/local/tomcat/webapps/todoList_war_exploded
EXPOSE 8081
CMD ["catalina.sh", "run"]