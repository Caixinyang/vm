##vm-config-server:
	# 动态刷新配置：
    curl -X POST  http://192.168.11.222:35070/refresh
    curl -X POST http://192.168.11.222:35070/restart
    # bus动态刷新
    curl -X POST http://39.108.231.231:44922/bus/refresh