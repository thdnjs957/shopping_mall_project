|시나리오|API 목록|url|explan|예상일정|예상소요시간|개발일정|개발시간|링크|
|-----|------|---|---|----|----|----|----|----|
|사용자 시나리오|회원가입 API|POST /user/join|회원가입|07월 16일|
||로그인 API|POST /user/login|로그인|07월 16일|
||회원정보수정 API|POST /user/update|회원 정보 수정|07월 16일|
||회원주문체크 API|GET /user/checkId||07월 16일|
||회원 주문 API|POST /order|주문하기||
|||GET /order|주문내역 확인||
||회원 장바구니 API|POST /basket|장바구니 담기||
|||GET /basket|장바구니 조희||
|||DELETE /basket|장바구니 삭제||
||배송 관리 API|GET /addr|배송지 목록 조회|07월 17일|
|||POST /addr|배송지 등록|07월 78일|
|||PUT /addr|배송지 수정|07월 17일|
|||DELETE /addr|배송지 삭제|07월 17일|
||상품 조회 API|GET /product/{category_no}|상품 조회|07월 18일|
||상품 상세 조회 API|GET /product/{category_no}/{product_no}|상품 상세 조회||
|관리자 시나리오|상품관리 API|GET /product|상품 목록 조회||
|||POST /product|상품 목록 조회||
|||POST /product/register|상품 등록||
|||PUT /product|상품 수정||
|||DELETE /product|상품 삭제||
||카테고리 관리 API|GET /category|카테고리 조회||
|||POST /category|카테고리 등록||
|||PUT /category|카테고리 수정||
|||DELETE /category|카테고리 삭제||
||회원 관리 API|GET /userManage|회원 조회||
|||POST /userManage/searchUser|회원 검색 후 조회||
