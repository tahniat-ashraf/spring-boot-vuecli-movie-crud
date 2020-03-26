Added components -
- Vuex
- BootstrapVue
- Vuetify

# How to run
1. backend > mvn spring-boot:run
2. frontend > npm run serve (for live refresh)

if you want to connect to mysql instead of H2,
1. backend > docker-compose up
2. go to browser's http://localhost:8080 to visit adminer's login page
3. Put username as root & password as rootpassword
4. After successful login, create a database named 'sv_movies'
5. export spring_profiles_active=mysql
6. backend > mvn spring-boot:run
7. frontend > npm run serve (for live refresh)


# How to deploy
1. backend > mvn clean package
2. Deploy .war in container
