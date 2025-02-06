How to build this archetype:
```sh
mvn clean install
```

Then you can create a new (Talend Component Kit)[https://talend.github.io/component-runtime/main/latest/index.html] (TCK) project with:
```sh
mvn archetype:generate -DarchetypeGroupId=org.github.ypiel.tck.archetype \
                       -DarchetypeArtifactId=new-tck-container-archetype \
                       -DarchetypeVersion=1.0-SNAPSHOT 
```
