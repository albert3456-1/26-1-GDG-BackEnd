1. 상품 조회
    HTTP Method: GET
    URI: /things
2. 상품 상세조회
   HTTP Method: GET
   URI: /things/{thingsID}
3. 주문 정보 저장
   HTTP Method: POST
   URI: /requests/{memberID}
4. 주문 처리 완료 
   HTTP Method: DELETE
   URI: /requests/{memberID}
5. 상품 추가
    HTTP Method: POST
    URI:/things
6. 상품 삭제
   HTTP Method: DELETE
   URI: /things/{thingsID}
7. 상품 품절
   HTTP Method: PATCH
   URI: /things/{thingsID}

![img.png](img.png)

사실 클라이언트와 서버간의 기본적인 동작 구조를 비롯 몇가지는 알고 있었다.
그러나 API의 정확한 정의, 그리고 HTTP/HTTPS의 의미를 새롭게 알게 되었다.
또한 RESTAPI가 뭔지, 어떤방식으로 웹을 짜야하는지에 대한 기초를 확실하게 다질 수 있게되어 좋았다.

