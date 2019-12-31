import requests
import sys
import json

appId = "wx882769e007a9573e"
secret = "55867e74554df906a8f7d81036c91fa4"

urlName = "https://api.weixin.qq.com/sns/jscode2session?appid=" + appId + \
    "&secret=" + secret + "&js_code=" + sys.argv[1] + "&grant_type=authorization_code"
if __name__ == '__main__':
    response = requests.get(urlName)
    print (json.loads(response.text).get("openid"))