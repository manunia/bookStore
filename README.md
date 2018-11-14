Тестовое задание: Java Developer
Цель: разработка серверного приложения на языке java, соответствующее REST архитектуре.
Описание: Имеются сущности
                - Книга: отражает сущность физической книги с оптимальным списком атрибутов на усмотрение разработчика
                - Автор: автор книги, дополняющий сущность книги
                - Список желаний: список книг, которые пользователь желает приобрести(ведение списка в разрезе пользователя не обязательно)
Задача: реализовать API для взаимодействия со всеми сущностями, реализовав все типы запросов GET/POST/PUT/DELETE. Так же стоит учесть каскадность зависимости объектов, обеспечивая ссылочную целостность.


# bookStore
простой REST сервис
сервис позволяет взаимодействовать с сущностями при помощи GET/POST/PUT/DELETE запросов. Сущности имеют отношения Многие к Ондному.
В главном классе добавлен метод добавления тестовых начальных данных.
Добавлять, удалять, обновлять  и получать данные можно при помощи fetch запросов из консоли браузера:

// GET all
fetch('/book/').then(response => response.json().then(console.log))

// GET one
fetch('/book/2').then(response => response.json().then(console.log))

// POST add new one
fetch(
  '/book', 
  { 
    method: 'POST', 
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({ text: 'some text', id: 10 })
  }
).then(result => result.json().then(console.log))

// PUT save existing
fetch(
  '/book/4', 
  { 
    method: 'PUT', 
    headers: { 'Content-Type': 'application/json' }, 
    body: JSON.stringify({ text: 'text redacted', id: 10 })
  }
).then(result => result.json().then(console.log));

// DELETE existing
fetch('/book/4', { method: 'DELETE' }).then(result => console.log(result))
