# Cuaderno

Cuaderno is an Android application that allows users to design and view a customized virtual notebook page. Users can select different styles for horizontal and vertical lines, including thickness and color themes, to create a personalized notebook experience.

## Features

The application consists of two main screens:

### Customization Screen (`MainActivity`)

This is the initial screen where you can customize the appearance of your notebook page. You have the following options:

*   **Horizontal Line Thickness**: Choose between 'normal', 'fino' (thin), or 'grueso' (thick) for the horizontal lines.
*   **Vertical Line Thickness**: Choose between 'normal', 'fino' (thin), or 'grueso' (thick) for the vertical lines.
*   **Horizontal Line Color Theme**: Select a color theme for the horizontal lines. Options include 'clasico' (classic), 'floral', and 'fresco' (fresh).
*   **Vertical Line Color Theme**: Select a color theme for the vertical lines. Options include 'clasico' (classic), 'floral', and 'fresco' (fresh).

Once you've made your selections, tap the "Crear" (Create) button to generate and view your customized notebook page.

### Notebook Page Screen (`hoja`)

After customizing and tapping "Crear", this screen displays the virtual notebook page. It renders the lines according to the thickness and color themes you selected in the previous screen. The drawing is handled by a custom view component (`Lienzo`) that dynamically creates the visual representation of the notebook page.

## How to Build

This project is a standard Android application built with Gradle.

1.  **Clone the repository:**
    ```bash
    git clone <repository-url>
    ```
    (Replace `<repository-url>` with the actual URL of this repository)

2.  **Open in Android Studio:**
    *   Launch Android Studio.
    *   Select "Open an existing Android Studio project".
    *   Navigate to the cloned directory and select it.
    *   Android Studio will automatically sync the Gradle project.

3.  **Build using Gradle (command line):**
    *   Navigate to the root project directory in your terminal.
    *   To build the debug APK:
        ```bash
        ./gradlew assembleDebug
        ```
    *   To build the release APK (you'll need to configure signing):
        ```bash
        ./gradlew assembleRelease
        ```
    *   To run tests:
        ```bash
        ./gradlew test
        ```
    *   To clean the build:
        ```bash
        ./gradlew clean
        ```

## Screenshots

*(Optional: You can add screenshots of the `MainActivity` and `hoja` activity here to give users a visual preview of the application.)*

**Example:**

*MainActivity - Customization Screen:*
`[Insert Screenshot of MainActivity Here]`

*hoja Activity - Notebook Page View:*
`[Insert Screenshot of hoja Activity Here]`
