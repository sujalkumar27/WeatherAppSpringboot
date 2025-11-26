# 🌤️ Weather App — Spring Boot

A simple weather application built using **Spring Boot** that fetches real-time weather details for any city using an external Weather API.
---
## 🚀 Features

* Search weather by city name
* Shows temperature, humidity, wind, and condition
* Clean UI (Bootstrap + custom CSS)
* REST API powered by Spring Boot
* External API integration (OpenWeatherMap)

---
## 🛠️ Tech Stack

* **Java 17+**
* **Spring Boot**
* **Thymeleaf**
* **Bootstrap 4**
* **Weather API** (OpenWeatherMap)
---
## 📦 How to Run
1. Clone the project:
   ```bash
   git clone https://github.com/sujalkumar27/WeatherAppSpringboot.git
   ```
2. Add your API key in `application.properties`:
   ```properties
   weather.api.key=YOUR_API_KEY
   ```
3. Run the app:
   ```bash
   mvn spring-boot:run
   ```
4. Open in browser:
   **[http://localhost:8081](http://localhost:8081)**

## 📁 Project Structure

```
src/
 ├── main/java/.../controller     → Controller layer
 ├── main/java/.../service        → Business logic
 ├── main/resources/templates     → HTML (Thymeleaf)
 ├── main/resources/static        → CSS, JS, images
```
## 🌎 API Endpoint
```
GET /weather?city=Delhi
```
Returns weather information for the given city.
---
## 🎨 UI Preview

* City search box
* Weather result card
* Icon + temperature + details
---
* Add caching
* Add error handling for invalid cities
* Add forecast (3-day/5-day)
