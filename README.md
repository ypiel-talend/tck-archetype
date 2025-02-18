How to build this archetype:
```shell
mvn clean install
```

Then you can create a new [Talend Component Kit](https://talend.github.io/component-runtime/main/latest/index.html) (TCK) project with:
```shell
mvn archetype:generate -DarchetypeGroupId=org.github.ypiel.tck.archetype \
                       -DarchetypeArtifactId=new-tck-container-archetype \
                       -DarchetypeVersion=1.0-SNAPSHOT 
```
It should create the new tck project in a sub-folder `./<artifact's name>/`. Go in to this folder and build the project:
```shell
mvn clean install
```
Then you can test the defined configuration in the web tester:
```shell
mvn talend-component:web -Dtalend.web.port=8080 -Dtalend.web.openBrowser=true
```
You can also deploy all defined connectors in a _Talend studio_:
```shell
java -jar target/MyArtifact-1.0-SNAPSHOT.car studio-deploy --location /path/to/a/studio/ -f
```