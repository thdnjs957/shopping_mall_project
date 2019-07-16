
### 회원가입 API [ POST /api/user/join ]
&#9992; request : <br>
<strong>params:</strong>
<pre>    
UserVo
{
  "no": null,
  "name": "박소원",
  "id": "thdnjs9570",
  "email": "thdnjs9570@naver.com",
  "gender": "MALE",
  "password": "Athdnjs@79",
  "phone": "01076363123",
  "role": "USER",
  "wdraw_date": null
}
<pre>

&#9992; response:

200: 성공 &#9989;
  <pre>
  Status = 200
  Error message = null
  Headers = {Content-Type=[application/json;charset=UTF-8]}
  Content type = application/json;charset=UTF-8
  Body = {
   "result" : "success",
   "message" : null,
   "data" : {
     "result" : true
   }
  }
</pre>


400: 실패 &#10060;
valid 체크 fail
<pre>
Status = 400
Error message = null
Headers = {Content-Type=[application/json;charset=UTF-8]}
    Content type = application/json;charset=UTF-8
Body = {
  "result" : "fail",
  "message" : "length must be between 2 and 6",
  "data" : null
}

</pre>

&#9998; 실제동작코드 <br>

UserController.java
<pre>
@PostMapping("/join")
	public ResponseEntity<JSONResult> join(@RequestBody @Valid UserVo userVo,BindingResult bResult) { //body에 json으로 오는거 받아내기

		if(bResult.hasErrors()) {
			List<ObjectError> list = bResult.getAllErrors();
			for(ObjectError error: list) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail(error.getDefaultMessage()));
			}
		}

		boolean result = userService.addUser(userVo);

		Map<String, Object> resultMap = new HashMap<String, Object>();

		resultMap.put("result", result);

		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(resultMap));
	}
</pre>



&#9998; TC CODE
<pre>
// 1. Normal User's Join Data
UserVo userVo = new UserVo(null,"박소원2","thdnjs9570","Athdnjs@7946","thdnjs9570@naver.com","01076363123",Gender.FEMALE,Role.USER,"2019-07-16",null);

ResultActions resultActions =
	mockMvc
	.perform(post("/api/user/join").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(userVo)));

resultActions.andExpect(status().isOk())
.andDo(print());

// 2. Invalidation in Name :
userVo = new UserVo(null,"박","thdnjs9570","Athdnjs@7946","thdnjs9570@naver.com","01076363123",Gender.FEMALE,Role.USER,"2019-07-16",null);

resultActions =
	mockMvc
	.perform(post("/api/user/join").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(userVo)));

resultActions.andExpect(status().isBadRequest())
.andDo(print())
.andExpect(jsonPath("$.result",is("fail")));

</pre>
