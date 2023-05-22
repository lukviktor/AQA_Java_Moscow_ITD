# AQA_Java_Moscow_ITD
## microservices-demo

## Вот текст тестового задания:

1. Поднять контейнер из https://github.com/microservices-demo/microservices-demo

2. Написать на языке Java e2e тест по авторизации и добавления товара в корзину

3. Проверить что сумма цены товаров в корзине соответствует сумме цен заказанных товаров

## Выполнение
### 1. Развертывание приложения с помощью Docker Compose
Это руководство описывает процесс развертывания и запуска приложения с помощью инструмента Docker Compose.
#### Предварительные требования
* Docker и Docker Compose должны быть установлены на вашем компьютере и запущен.
#### Шаги
1. Скачайте исходный код с репозитория GitHub:
```
git clone https://github.com/microservices-demo/microservices-demo.git
```
2. Перейдите в каталог `deploy/docker-compose`:
```
cd microservices-demo/deploy/docker-compose
```
3. Соберать все Docker-образы микросервисов командой:
```sh
docker-compose build
```
4. Запустите приложение с помощью команды:
```sh
docker-compose up -d
```
5. Для того, чтобы узнать порты, можно выполнить команду:
```sh
docker-compose ps
```
6. После того как приложение будет запущено, откройте веб-браузер и перейдите на страницу `http://localhost:80`. Откроется веб-интерфейс приложения.

7. Чтобы остановить приложение, выполните команду:
```sh
docker-compose down
```