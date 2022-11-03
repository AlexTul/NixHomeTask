Реалізувати програму (бібліотеку) з наступних компонентів

CSVParser
Дан файл у розширенні .csv. Структура файлу:

заголовок1,заголовок2,...,заголовокN,
значення 1-1, значення 1-2, ..., значення 1-N,
значення 2-1, значення 2-2, ..., значення 2-N,
...
значення N-1, значення N-2, ..., значення N-N,

Побудувати з цього файлу структуру даних CSVTable, яка дозволяє отримати доступ до
елементів таблиці
а) за номером рядка та стовпця (рядки не включають заголовки)
б) за номером рядка та текстом заголовка.
А також дозволяє отримати список заголовків.

CSVTable parse(Path path);

CSVTable parse(Reader source);

CSVMapper
На основі механізму CSVParser створити програмний компонент, який з таблиці
CSV даних створить список об'єктів заданого типу. Ініціалізацію даного об'єкту
провести за допомогою рефлексії, визначаючи поля, що заповнюються даними з таблиці за допомогою анотації.

<T> List<T> map(CSVTable table, Class<T> resultType);

Перевірка - написати декілька тестів на JUnit 5. Класи для маппінгу визначити в тестах (src/test)