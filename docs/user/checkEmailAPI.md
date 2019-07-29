
### 이메일 중복 체크 API [ GET /api/user/checkEmail ]
&#9992; request : <br>
<strong>params:</strong>

    user_email = 사용자 Email

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

&#9998; 실제동작코드 <br>

UserController.java
<pre>
@GetMapping("/checkemail")
public ResponseEntity<JSONResult> checkEmail(@RequestParam(value="email", required=true, defaultValue="") String email) {

  boolean exist = userService.existEmail(email);

  return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(exist));

}
</pre>



&#9998; TC CODE
<pre>
ResultActions resultActions =
		mockMvc
		.perform(get("/api/user/checkemail").param("email", "thdnjs9570@naver.com").contentType(MediaType.APPLICATION_JSON));
resultActions
		.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("success")))
		;

</pre>
