Створити новий проект під назвою lightshow
Створити БД з наступною схемою:

Colors (Кольори) (Entity name: Color)

PROPERTY	DESCRIPTION
id	Integer primary key
name	Unique name

Lights (Освітлювачі) (Entity name: Light)

PROPERTY	DESCRIPTION
id	Integer primary key
label	Unique name
color_id	Reference to the current color
enabled	Boolean

Color history (Історія зміни кольору) (Entity name: ColorHistoryRecord)

PROPERTY	DESCRIPTION
id	Integer primary key
ligth_id	Reference to the light
old_color_id	Reference to the old color
new_color_id	Reference to the new color
changed_at	UTC Timestamp


Створити таблиці, записав потрібний DDL код у файл schema.sql.
Заповнити таблицю colors тестовими даними у файлі data.sql.



Реалізувати наступну програму:

Користувач вводе:

-	label одного із світильників
-	Список кольорів
-	Інтервал між переключеннями (в секундах)
-	Кількість переключень

Валідація вводу:

-	Якщо у списку кольорів є неіснуючі - завершити виконання програми з помилкою
-	Якщо інтервал меньше 1, вийти з помилкою
-	Якщо кількість переключень меньше 1, вийти з помилкою
-	Якщо світильник із таким label не існує, створити новий Light із випадковим початковим кольором зі списку
-	Якщо світильник існує, але він наразі є enabled - завершити виконання програми з помилкою

Хід виконання програми:

1.	Зробити світильник enabled = true
2.	Змінити його колір на випадковий зі списку (окрім поточного), створивши відповідний запис в історії змін і записавши лог операції в форматі (Light ‘my light’ changed color from ‘red’ to ‘yellow’ at {{ISO timestamp}})
3.	Почекати заданий інтервал (Thread.sleep) // приймає значення в мс, тож привести введене значення * 1000
4.	Повторити кроки 2-3 задану кількість разів
5.	Виставити enabled = false
6.	Вивести всю історію переключень в форматі (Light ‘my light’ changed color ‘red’ => ‘yellow’ => ‘blue’ => ‘white’ => ‘red’)
7.	Завершити виконання програми

Логи писати в окремий файл, щоб не забивати ними консоль вводу-виводу. Логи на рівні info мають відображати хід виконання програми.

Для роботи з БД використовуйте JPA/Hibernate
