
### 로그인 API [ POST /api/user/login ]
&#9992; request : <br>
<strong>params:</strong>

       user_id = 사용자ID
       user_pwd = 사용자 비밀번호  

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
   "userVo" : {
     "no" : 6,
     "name" : "박소원",
     "id" : "thdnjs9570",
     "role" : "USER"
 }
}
</pre>


400: 실패 &#10060;
<pre>
     Status = 400
Error message = null
      Headers = {Content-Type=[application/json;charset=UTF-8]}
 Content type = application/json;charset=UTF-8
         Body = {
"result" : "fail",
"message" : "아이디 혹은 비밀번호가 틀렸습니다.",
"data" : null
}

</pre>

&#9998; 실제동작코드 <br>

UserController.java
<pre>
@PostMapping("/login")
public ResponseEntity<JSONResult> login(@RequestParam(value = "id", required = true, defaultValue = "") String id,
            @RequestParam(value = "password", required = true, defaultValue = "") String password) {

  Map<String, Object> map = new HashMap<String, Object>();

  map.put("id", id);
  map.put("password", password);

  UserVo vo = new UserVo(id,password);

  UserVo AuthUser = userService.getUser(vo);

  if(AuthUser == null) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail("아이디 혹은 비밀번호가 틀렸습니다."));
  }

  Map<String, Object> resultMap = new HashMap<String, Object>();
  resultMap.put("userVo", AuthUser);

  return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(resultMap));
}
</pre>



&#9998; TC CODE
<pre>
ResultActions resultActions =
		mockMvc
		.perform(post("/api/user/login").param("id", "thdnjs9570")
		.param("password", "Athdnjs@7946")
		.contentType(MediaType.APPLICATION_JSON));

    resultActions
			.andExpect(status().isOk())
			.andDo(print())
			.andExpect(jsonPath("$.result", is("success")))
			.andExpect(jsonPath("$.data.userVo.id", is("thdnjs9570")))
			.andExpect(jsonPath("$.data.userVo.name", is("박소원")))
			;

resultActions =
		mockMvc
		.perform(post("/api/user/login").param("id", "thdnjs957")
		.param("password", "Athdnjs@7946")
		.contentType(MediaType.APPLICATION_JSON));

	resultActions
		.andExpect(status().isBadRequest())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("fail")))
		;

</pre>
