Added components -
- Vuex
- BootstrapVue
- Vuetify

# How to run
1. frontend > npm run serve (for live refresh)
2. backend > mvn spring-boot:run

if you want to connect to mysql instead of H2,
1. frontend > npm run serve (for live refresh)
2. backend > docker-compose up
3. go to browser's http://localhost:8080 to visit adminer's login page
3. Put username as root & password as rootpassword
4. After successful login, create a database named 'sv_movies'
5. export spring_profiles_active=mysql
6. backend > mvn spring-boot:run

# How to deploy
1. backend > mvn clean package
2. Deploy .war in container