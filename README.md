# Planer treningów 🏋️‍♂️

Aplikacja mobilna na system Android stworzona w środowisku **Android Studio** (interfejs w języku **XML**, logika w języku **Java**). Służy do losowania ćwiczeń podczas treningu oraz zliczania wykonanych serii dla bieżącego ćwiczenia i całego treningu.

---

## ✨ Funkcjonalności

* **Losowanie ćwiczenia (`LOSUJ ĆWICZENIE`)** – losuje jedno z 6 dostępnych ćwiczeń za pomocą klasy `Random`, wyświetla przypisaną do niego grafikę oraz nazwę, a także zeruje licznik serii bieżącego ćwiczenia.
* **Zliczanie serii (`+` / `−`)** – pozwala zwiększać lub zmniejszać liczbę serii aktualnego ćwiczenia (wartość licznika nie spada poniżej `0`).
* **Przejście do kolejnego ćwiczenia (`NASTĘPNE ĆWICZENIE`)** – dolicza serie z bieżącego ćwiczenia do łącznej liczby serii, aktualizuje podsumowanie, losuje nowe ćwiczenie i zeruje bieżący licznik.
* **Resetowanie treningu (`RESET`)** – przywraca aplikację do stanu początkowego (zeruje oba liczniki, ustawia grafikę `cwiczenie0.png` oraz napis `Losuj ćwiczenie`).

### Dostępne ćwiczenia

| Numer | Nazwa ćwiczenia | Zasób graficzny |
| :---: | :--- | :--- |
| 0 | *Stan początkowy* | `cwiczenie0.png` |
| 1 | Przysiad | `cwiczenie1.png` |
| 2 | Pompki | `cwiczenie2.png` |
| 3 | Plank | `cwiczenie3.png` |
| 4 | Wykroki | `cwiczenie4.png` |
| 5 | Burpees | `cwiczenie5.png` |
| 6 | Podciąganie | `cwiczenie6.png` |

---

## 🛠️ Technologie

* **Język programowania:** Java
* **Warstwa widoku (UI):** XML (`LinearLayout`, `MaterialCardView`, `MaterialButton`)
* **Środowisko:** Android Studio

---

## 📂 Struktura głównych plików

```text
app/src/main/
├── java/com/example/planertreningow/
│   └── MainActivity.java          # Główna logika aplikacji
└── res/
    ├── drawable/                  # Grafiki (sportowiec.png, cwiczenie0.png - cwiczenie6.png)
    └── layout/
        └── activity_main.xml      # Układ interfejsu użytkownika
