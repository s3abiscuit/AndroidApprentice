# RemoteViews

## Notification中定义视图

## Widget中定义视图

原理是广播接收

widget的使用

1. create AppWidgetProvider(a broadcast receiver)
2. override onReceiver() & onUpdate()
3. create RemoteViews(@xml/layout, pendingIntent, manifest declaration, @xml/widget info) in onUpdate()
4. onReceive()中处理pendingIntent定义的action


