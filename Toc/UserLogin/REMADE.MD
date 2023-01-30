## 注册模块
 ```html
接口1
前端向后端发送手机号：
    1.校验该手机号的格式
    2.该手机号注册过，返回该手机号注册过的账号。
    3.该手机号未注册过，向该手机号发送短信。
POST /tcu/user/register
Content-Type: application/json

{
    phoneNumber: ''
}

# 正常响应 发送验证码
{
    "code": 50200
    "data": "OK"
}

# 手机号码重复
{
    "code": 50400
    "msg": "登录失败，手机号已存在"
}

接口2
前端向后端发送手机号与接口1发送的验证码
    1.校验该手机号格式
    2.该验证码是否正确、过期
POST /tcu/user/register/authcode
Content-Type: application/json
{
    phoneNumber: ''
    authCode: ''
}

# 正常响应
{
    "code": 50200
    "data": "OK"
}

# 验证码错误
{
    "code": 50404
    "msg": "验证码错误"
}

# 验证码已经失效
{
    "code" ： 50400
    "msg": "验证码已经失效"
}

接口3
    前端向后端发送账号
        1.进行账号校验
            1.1 长度6-18位,不包括非法字符。
            1.2 前置或后置空格无效
            1.3 该账号未被用
POST /tcu/user/register/username
Content-Type: application/json
{
    username: 123456''
}

# 正常响应
{
    "code": 50200,
    "data": "OK"
}
# 长度不合法，
{
    "code": 50400
    "msg": "长度不合法"
}
# 该账号已经存在
{
    "code": 50401
    "msg": "该账号已存在"
}

接口4
    前端向后端发送密码
        1.进行密码校验
            1.1 长度6-18位
            1.2 前置或后置空格无效
            1.3 判断密码的强度
POST /tcu/user/register/password
Content-Type: application/json
{
  password: ''
}

# 正常响应
{
  "code": 50200
  "data": 1/2/3  (1-强，2-中，3弱)
}

# 长度不合法，
{
  "code": 50400
  "msg": "长度不合法"
}

接口5 /tcu/user/register/sendUserCode
Content-Type: application/json
    前端向后端发送email
        1.进行邮箱校验
            1.1 邮箱格式是否正确
            1.2 该邮箱是否被用,被用时，返回，该邮箱已经绑定的账号
            1.3 未被用时候，向该邮箱发送验证码
            
{
  email: ''
}
# 正常响应 向该邮箱发送验证码
{
  "code": 50200
  "data": "OK"
}
# 邮箱格式不对
{
    "code": 50400
    "msg": "邮箱格式错误"
}
# 该邮箱已经存在
{
    "code": 50401
    "data": "username"
}

接口6
前端向后端发送该用户的信息
    1.对emailCode进行校验
        1.1 该emailCode是否错误
        1.2 该emailCode是否过期
    2. 随机生成头像
    3. 保存密码惊醒md5二次家里并加入随机字符串salt
POST /tcu/user/register/userinfo
{
    username: ''
    password: '',
    email: '',
    imgUrl: '',
    emailCode: ''
}

# 正常响应 注册成功
{
    "code": 50200
    "data": "OK"
}

# 验证码错误
{
    "code": 50404
    "msg" : "验证码错误"
}
# 验证码已经失效
{
    "code" ： 50400
    "msg": "验证码已经失效"
}
...


