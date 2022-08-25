function fn() {
    karate.configure('connectTimeout', 6000);
    karate.configure('readTimeout', 6000);
    var config;
    if (karate.env == 'mock') {
         config ={ baseUrl : karate.properties['mock.greetings.url']};
    } else{
         config ={ baseUrl : 'https://spring-boot-api-stage.herokuapp.com'};
    }
    return config;
}