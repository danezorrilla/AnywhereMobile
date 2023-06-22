# AnywhereMobile
# On Phones, the list and detail should be separate screens, on Tablets, list and detail should appear on the same screen.
· For the list view, data should be displayed as a text only, vertically scrollable list of character names.
· The app should offer search functionality that filters the character list according to characters whose titles or descriptions contain the query
text
· Clicking on an item should load the detail view of that character, including the character’s image, title, and description. You choose the layout
of the detail.
· For the image in the detail view, use the URL in the "Icon" field of the API JSON response. For items with blank or missing image URLs, use
a placeholder image of your choice.
· Two variants of the app should be created, using a single shared codebase. Each variant should have a different name, package-name, and
url that it pulls data from. (We're interested in your methodology for creating multiple apps from a shared codebase)
Variant One
Name: Simpsons Character Viewer
Data API: http://api.duckduckgo.com/?q=simpsons+characters&format=json
Package/Bundle name: com.sample.simpsonsviewer

Version Two
Name: The Wire Character Viewer
Data API: http://api.duckduckgo.com/?q=the+wire+characters&format=json
Package/Bundle name: com.sample.wireviewer
