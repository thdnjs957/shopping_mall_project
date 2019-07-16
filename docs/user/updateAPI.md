
### 회원 정보 수정 API [ POST /api/user/update ]
&#9992; request : <br>
<strong>params:</strong>
<pre>    
UserVo
{
  "name": "박소원",
  "email": "thdnjs9570@naver.com",
  "phone": "01012345678",
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
@PutMapping("/update")
public ResponseEntity<JSONResult> update(@RequestBody UserVo userVo) {

	userVo.setNo(6L); //수정될 유저 번호

	boolean result = userService.updateUser(userVo);

	return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(result));

}
</pre>


&#9998; TC CODE
<pre>
UserVo vo = new UserVo();

//수정할 정보
vo.setName("박소원");
vo.setEmail("thdnjs9570@naver.com");
vo.setPhone("01045613256");

ResultActions resultActions =
	mockMvc
	.perform(put("/api/user/update").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));

resultActions.andExpect(status().isOk())
.andDo(print())
.andExpect(jsonPath("$.result", is("success")))
.andExpect(jsonPath("$.data", is(true)))
		;
</pre>
