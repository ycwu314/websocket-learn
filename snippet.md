
# js创建websocket

```javascript
var ws = new WebSocket("ws://echo.websocket.org"); 
 ws.onopen = function(){ws.send("Test!"); }; 
 ws.onmessage = function(evt){console.log(evt.data);ws.close();}; 
 ws.onclose = function(evt){console.log("WebSocketClosed!");}; 
 ws.onerror = function(evt){console.log("WebSocketError!");};
```

# chrome控制台导入js文件

```javascript
inject = document.createElement('script');
inject.src = "https://cdn.bootcss.com/sockjs-client/1.1.4/sockjs.js";
document.getElementsByTagName('head')[0].appendChild(inject);

inject2 = document.createElement('script');
inject2.src = "https://cdn.bootcss.com/stomp.js/2.3.3/stomp.js";
document.getElementsByTagName('head')[0].appendChild(inject2);

```

# 前端使用stomp

```javascript
var socket = new WebSocket("ws://localhost:8080/ws");
var client = Stomp.over(socket);
var auth_headers = {
              		'x-user': 'tom',
              		'x-password': '123456'
              	}; 
client.connect(
    auth_headers,
	function(frame) {
		console.log('frame='+frame);
		client.subscribe('/user/queue/greeting', function(data){
			console.log(JSON.parse(data.body));
		}, {} );
});

client.send('/app/greeting', {}, JSON.stringify({'name':'tom'}));

client.disconnect();

```



