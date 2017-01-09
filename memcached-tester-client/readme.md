# Get Start

```
./gradlew bootRun
```


# Develop

```
./gradlew clean idea
```


# How to use

## set

### URI

```
localhost:8080/basic/set
```

### method

POST

### param

```
{
	"key": "sample_key",
	"value": "sample_value1"
}
```

## get

### URI

```
localhost:8080/basic/get?key=sample_key
```

### method

GET

### Result

```
sample_value1
```


## delete

### URI

```
localhost:8080/basic/delete?key=sample_key
```

### method

DELETE