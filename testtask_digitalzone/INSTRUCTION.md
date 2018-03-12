# My-project
Для тестирования необходимо установить на компьютер
1.IDE(Intellij IDEA, etc)
2. Postgresql
3. Postman

1. Запустить PGadmin из пакета postgresql
2. Создать базу с именем: test_digital_zone, login: postgres, password: qwerty
3. Выполнить запрос в консоли запрос:
"CREATE TABLE page (
page_id INTEGER,
user_id INTEGER,
time_visit TIMESTAMP
 )"
4. Открыть проект в IDE
5. Запустить проект на выполнение
6.Запустить программу Postman
7. В открывшемся окне, авторизоваться, либо зарегистрироваться в системе. 
8. в url прописать "localhost/visit"
9. Нажать Param и добавть 2 параметра(Key) user_id и page_id, Значение можно указать любое числовое
10. Нажимаем SEND
11. Ниже отображаются результаты: статистика посещения за день и количество уникальных посетителей

12. Прописываем в url "localhost/period_visit"
13. Добавляем 2 параметрa(key) : from, to
Value в формате "ГГГГ-ММ-ДД"
14. Нажимаем SEND и получаем статистику посещения за заданный период
 
 
