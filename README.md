# Discord 

![Maven](https://img.shields.io/maven-central/v/com.github.rillis/discord)
![License](https://img.shields.io/github/license/rillis/discord)


```xml
<dependency>
  <groupId>com.github.rillis</groupId>
  <artifactId>discord</artifactId>
  <version>1.0.0</version>
</dependency>
```

## Docs

**Example:**  
```java
String webhookUrl = "";
Discord discord = new Discord(webhookUrl,"RillisBOT", "https://via.placeholder.com/400x400.png");

//(1) only content:
String content = "FooContent";
try {
	discord.sendMessage(content);
} catch (IOException e) {
	e.printStackTrace();
}

//(2) content and/or embed(s):

//Setup content, in this case this can be null (only if embed != null)
content = "FooContent";

//Setup for embed

//Author stay on top of the message
//Author or any arguments can be null or blank
Author author = new Author("Rillis Vernucio","https://github.com/rillis/discord","https://avatars2.githubusercontent.com/u/16558619?s=460&u=a83e4a1703074c46f28baab5a67c37c687c2fcfd&v=4");

//Those can be blank or null
String title = "Title placeholder";
String url = "https://github.com/rillis/discord";
String description = "Description placeholder.";

//Color can be 0 if you don't want as a part of the message.
long color = 392183;

//Fields (isn't required), if you aren't using it just set:
//Field[] fields = null;
Field field1 = new Field("Foo1","Bar1",true);
Field field2 = new Field("Foo2","Bar2",true);
Field field3 = new Field("Foo3","Bar3",false);
Field[] fields = {field1, field2, field3};

//Any of those can be null
Thumbnail thumbnail = new Thumbnail("https://via.placeholder.com/200x400.png");
Image image = new Image("https://via.placeholder.com/350x350.png");
Footer footer = new Footer("Footer text", "https://via.placeholder.com/400x400.png");

//Setup embed using variables above
Embed embed = new Embed(author, title, url, description, color, fields, thumbnail, image, footer);

//embed field can be an array for multiple embeds
try {
	discord.sendMessage(content,embed);
} catch (IOException e) {
	e.printStackTrace();
}
```