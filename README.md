# Тестовое задание для SHIFT LAB 2024 (Back-End, Java)
## Endpoints
+ POST /api/v1/intervals/merge?kind=digits - **добавление интервала целых чисел**
+ POST /api/v1/intervals/merge?kind=letters - **добавление интервала букв**
+ GET /api/v1/intervals/min?kind=digits - **запрос минимального интервала целых чисел**
+ GET /api/v1/intervals/min?kind=letters - **запрос минимального интервала букв**
## Локальный запуск
Сборка при помощи gradle, локальный запуск с помощью IntelliJ IDEA, точка запуска - класс Main.


База данных - H2. Доступ к БД осуществлется после запуска приложения: <http://localhost:8080/h2-console>

JDBC URL: jdbc:h2:mem:mydb  
User Name: sa  
Password: password  
