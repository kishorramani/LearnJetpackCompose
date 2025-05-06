# Jetpack Compose Course 📱✨

Welcome to the **Jetpack Compose Course**! This course is designed to guide you through the fundamentals of Jetpack Compose, Android's modern toolkit for building native UI. Whether you're a beginner or looking to enhance your UI development skills, this course offers practical examples and hands-on experience.

---

## 🎥 Course Playlist

📺 **Start Here**: [Video 1: Introduction](https://youtu.be/GXfOFQGG1rM?si=GNBxWnklNfGHnZkv)  
=> Video 1: https://youtu.be/GXfOFQGG1rM?si=GNBxWnklNfGHnZkv
## 🧠 What is Jetpack Compose?
Jetpack compose is modern UI toolkit that simplified and accelerates the process of building user interfaces through a declarative and kotlin-based approach.

### 💡 Why Jetpack Compose > XML?
Declarative syntax - JC allows developers to express UI elements more concisely compared to XML. This leads to cleaner and more maintainable code
Reduce Boilerplate code - with compose, UI component are defined directly in kotlin, reducing redundancy and making the codebase more efficient.
Live Preview - JC provides real-time previews, enabling developer to see changes instantly as they code

### No Need for
XML layout - All UI related code is in the kotlin class itself so no need of xml
Multiple activities - One activity is serve as Entry point 
Fragments - Jetpack compose is capable to building, maintaining and updating UI
Data/View Binding - As we don't have layout so there is no need of find view by id or data binding or view binding

### Annotations
@Preview - It provides real-time previews, enabling developers to see changes instantly as they code
@Composable - It defines UI elements, allowing for a modular and reusable approach to building user interfaces through a declarative pattern (Compose function not a kotlin function - UI related functions)

### Project structure
Manifest and gradle file is same
=> 2 changes 
1: Theme folder
2: No directories for xml

ui.theme/Color.kt
ui.theme/Theme.kt
ui.theme/Type.kt
MainActivity.kt

=> Video 2: https://youtu.be/bvQym_hszeI?si=3odQpT_yxAdbnMBT
Splash Screen [Refer mainActivity]

=> Video 3: https://youtu.be/RMQPHljE82I?si=BkAVdRF9K7JR-awA
Text Composable and Modifiers [Refer ATextAndModifiers]

=> Video 4: https://youtu.be/YbVm9Ue_J7E?si=FIZolyc98D2esrI5
Row Column and Box [Refer BRowColumnBox]

=> Video 5: https://youtu.be/bo5TAnctPCA?si=MpD9KJEoI7OFvHkY
Alignment & Arrangement [Refer CAlignmentArrangement]

Alignment[Position] - Cross Axis => Alignment refers to the positioning of the composable element within its parent container, specifying how it should be placed relative to the available space along the horizontal and vertical axis
Row -> Vertical
Alignment parameter => Top, Center vertically, bottom

Column -> Horizontal
Alignment parameter => Start, Center Horizontally, End

Arrangement - Main Axis => Arrangement defines the distribution of multiple composable within a container, determining their placement along the main axis  
Row = Horizontal
Arrangement parameter => Start, Center, End - Space Between, Space Around, Space Evenly, Absolute, etc

Column = Vertical
Arrangement parameter => Top, Center, Bottom - Space Between, Space Around, Space Evenly

Box => Only Alignment is working
Alignment parameter => TopStart, TopCenter, TopEnd, BottomStart, BottomCenter, BottomEnd, Center, CenterStart, CenterEnd

=> Video 6: https://youtu.be/Ht0W-zNl59A?si=uBPHekYIrMr7l9uZ
Button and Image  [Refer DButtonAndImage]

=> Video 7: https://youtu.be/ClWcRPJ3Eyc?si=90kv3y8gxgxWzUR6
State -> Mutable Variable  [Refer EState]
In Jetpack compose, the "state" is refer to a mutable variable that triggers recomposition when it's value changes, allowing the UI to automatically reflect the updated state without manual intervention.
It is a key concept for managing and updating UI elements dynamically. 

--> State vs Variables 
1: Recomposition trigger
State -> It trigger recomposition when their value changes, it automatically updating the UI to reflect the new state
Variable -> It do not trigger recomposition and require manual UI updated 

2: Observability
State -> State are observable, enabling the framework to efficiently track changes and optimize UI updates.
Variable -> Regular variable lack this built-in observability

3: Immutable Vs Mutable
State -> State are designed to be mutable and allow modification within a composable function
Variable -> Regular variable are typically immutable 

4: Scoped to Composable
State -> State are often scoped to composable functions, ensuring that the state is localized and specific to the UI component 
Variable -> Regular variable may have a broader scope

--> Syntax
Normal variable - var age = 0
state variable - var age by remember { mutableStateOf(0) }

by -> In Kotlin, the "by" keyword is used in conjuction with the delegate pattern to create delegated property
      delegated properties allows you to implement the getter and setter logic for a property in a separate class

remember -> In Jetpack compose, "remember" is a function used to retain the state across recomposition, persisting it's value between calls to the composable function. 
            It particularly useful for preserving stateful data without recomputing or resetting during UI updated. 

mutableStateOf -> In Jetpack compose, "mutableStateOf" is a function that creates a mutable state variable.
                  It returns a pair containing the current value and setter function. allowing modification of the state and triggering the UI recomposition when the value changes. 

=> Video 8: https://youtu.be/Ahv0niXd_aY?si=8O5GxK4Z2EPEds9h
Top App Bar  [Refer FTopAppBar]

=> Video 9: https://youtu.be/_gDK4r_0x9Y?si=oC27y6Fm3VR1aGK9
Navigation Drawer  [Refer g_navigation_drawer - GNavigationDrawer]

=> Video 10: https://youtu.be/L8knAaFq3m8?si=c9kIXdS0e2KA2dRD
Bottom Navigation  [Refer h_bottom_navigation - HBottomNavigation]

=> Video 11: https://youtu.be/tkqlg25lIL0?si=qg5DxYQBIFlZcjNM
Bottom Sheet  [Refer i_bottom_sheet - IBottomSheet]

=> Video 12: https://youtu.be/KkJb6rx0gC4?si=K7W_Ew0VroMu0Gk3
Bottom Navigation  [Refer j_bottom_nav_drawer_sheet - JBottomNavDrawerSheet]
Bottom Sheet
Navigation Drawer

=> Video 13: https://youtu.be/T4A1TtF-g5U?si=qDTOyUzATq4Xcu6h
Simple Login Page  [Refer k_login_page - KLoginPage]

=> Video 14: https://youtu.be/zf6QJemVs2k?si=tNQ-JGkbqYT9Yeuk
List, Lazy column, Lazy Row [refer l_list_lazy_column_row - LListLazyColumnRow]

List => List of UI component used to display  a scrollable collection of items vertically or horizontally.

Lazy Column => A Lazy column is a Composable UI component in jetpack compose used to display a vertically-scrollable list of items with lazy loading for efficiency.

Lazy Row => A Lazy row is a Composable UI component in jetpack compose used to display a horizontally-scrollable list of items with lazy loading for efficiency. 

=> Video 15: https://youtu.be/tk_4jaOFUtw?si=E6TIqWsQ65bcoM4x
Constraint layout [refer m_constraint_layout - MConstraintLayout]

Layout in XML
Linear Layout, Relative Layout, Constraint Layout

Layout in Jetpack Compose
Column Layout, Row Layout, Box Layout, Constraint Layout

Concept
1: How to create constraint layout and refs
2: Dimension
3: Chain 
4: Guideline

=> Video 16: https://youtu.be/a3Y2uncgAMM?si=qkg6Zi6bhqvE5CJD
Navigation Component [refer n_navigation_component - NNavigationComponent]

Navigation component is a library that can manage navigation flow, transition animation, deep linking and passing the data in the app.
- It manage navigation flow using destinations, actions, visual editor and components enhancing development efficiency. 

Components 
1: Nav graph -> Nav graph is present inside the nav host which specifies the route or the destinations. 
2: Nav Host -> Nav Host is associated with the Nav Controller that initialize the navigation. 
3: Nav Controller -> Nav controller manages all the navigation that takes place with the help of Nav host and Nav graph

2 way to use
1: Keywords
2: Sealed class 

=> Video 17: https://youtu.be/57LBdPAnuLk?si=EOt39MOqXRnSpqcT
mvvm

mvvm -> Model-View-ViewModel
Model -> Data
View -> UI
ViewModel -> Logic (Bridge between view and model)

App using MVVM
- Easy to Test
- Easy to Maintain
- Organized 

=> Video 18: https://youtu.be/laGD8iYV3hQ?si=uGDbvnsPsjBukrvd
Dashboard UI Design - I skip to development part for this

=> Video 19: https://youtu.be/ppbyVn2SJ9Y?si=QQKBl1ryj60zjnwP
Floating Action Button [refer p_floating_action_button - PFloatingActionButton]

=> Video 20: https://youtu.be/4JoCUPVzqMo?si=x-qKvIrJoS-iqV_r
Card [refer q_card - QCard]

=> Video 21: https://youtu.be/lH9vyVuCK7o?si=ompTWwdqFPrGpNTZ
Check box [refer r_check_boxes]


## 🙌 Final Note

> **Thanks me later — but first, finish learning Jetpack Compose! 😉**

Feel free to fork, clone, explore, and expand this project. Happy Composing! 🎨
