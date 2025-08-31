# 🌦️ Weather App (Java, Console)

## 📌 Project Details
- **Internship**: CodeClause Java Development Intern  
- **Project ID**: CC5258  
- **Level**: Entry Level  
- **Title**: Weather App  
- **Developer**: Gali Dinesh Reddy  

---

## 🎯 Aim
Build a simple **console-based Weather Application** in Java that retrieves and displays current weather information for a given city.

---

## 📝 Description
This Java program connects to the **OpenWeatherMap API** to fetch live weather data.  
Users can enter the **city name**, and the program displays:
- Location & Country  
- Weather Condition  
- Temperature (°C)  
- Feels Like Temperature  
- Humidity  

---

## ⚙️ Technologies Used
- **Java 8**  
- **OpenWeatherMap API**  
- **Gson Library** (for JSON parsing)

---

## 🚀 How to Run

**1. Download Gson**

Download Gson JAR

Place it in the same folder as WeatherApp.java.

**2. Set API Key**

Set your OpenWeatherMap API key as an environment variable:

Windows (CMD):

setx OPENWEATHER_API_KEY "your_api_key_here"


Linux / macOS:

export OPENWEATHER_API_KEY="your_api_key_here"

**3. Compile**
javac -cp gson-2.11.0.jar WeatherApp.java

**4. Run**
java -cp .:gson-2.11.0.jar WeatherApp



**📸 Sample Output**
Enter city name (e.g., Hyderabad or Hyderabad,IN): Mumbai

===== Current Weather =====
Location   : Mumbai, IN
Condition  : overcast clouds
Temp       : 26.74 °C (feels 29.83 °C)
Humidity   : 88 %

**📚 Learning Outcome**

Learned how to use a public REST API in Java.

Practiced JSON parsing with Gson.

Understood environment variables for security (API keys).

Improved debugging skills while handling API errors (401, invalid key).

**👉 Screenshots of outputs**
<img width="732" height="167" alt="image" src="https://github.com/user-attachments/assets/b0d08985-5281-4bf8-b0df-d20f65111696" />

<img width="721" height="165" alt="image" src="https://github.com/user-attachments/assets/b223609d-6871-47b8-b2bc-01c3aa466000" />

