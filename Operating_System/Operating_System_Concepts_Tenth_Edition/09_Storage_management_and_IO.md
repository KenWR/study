Mass-Storage

- 비휘발성의 보조기억장치

- HDD or NVM

- 자기테이프나 광학 디스크, 클라우드 저장소 등을 사용하기도함
  - 이들은 RAID 시스템 사용

우리가 하드디스크를 I/O 하려면 Scheduiling 해줘야함

스케줄링에는 2가지 가장 큰 목표가 있음
- 접근시간 최소화(seek time)

- 데이터 전송 최대화(bandwidth)

seek time 이란?

- arm 의 헤드가 필요한 섹터의 실린더에 도달하는 시간  

- 또한 플래터가 필요한 섹터쪽으로 돌리는데 걸리는 시간도 포함됨

disk bandwidth(대역폭) 란?

- 전송된 총 바이트 수 / 서비스 요청이 들어오고 끝나는데 걸린 시간

### 스케줄링 종류

1. FIFO     
2. scan   
	- head가 최저 트랙번호(0) 방향으로 이동하는 방식   
3. C-scan
   - 기존의 스캔방식에서 한쪽 방향으로만 스캔을 수행하는 방식
   - 끝에 도달하면 반대방향으로 가지않고 처음으로 돌아와 다시 한방향으로 스캔을 시작


Boot block

ROM에 저장됨
컴퓨터를 처음 전원을 켰을때 실행할 프로그램을 저장하는 공간   


RAID

드라이브의 병렬 수행 - 스트라이핑   
신뢰성 향상 - 중복성, 이를 미러링이라고도함   

parity bit를 이용한 에러를 감지하거나 복구할수 있다

RAID 0 ~ 6 까지있음

I/O Systems

컴퓨터는 수많은 I/O 작업을 수행함   
OS는 I/O를 수행을 제어하고 I/O 장치를 관리함

I/O 장치 controller는 모두 버스를 지나고 그 controller들을 OS가 관리함   

Memory-Mapped I/O

프로세서가 어떻게 I/O 전송을 통해 명령어와 data를 controller에 전달하나?   
controller는 하나이상의 data 와 control signal들을 받기위한 레지스터가 존재함
- data in : in   
- data out :   
- status :   
- control :   

I/O address에 각 장치들을 mapping 시켜 물리주소에 있는 주소를 통해 정보를 전달하는것   

I/O 종류

- polling(busy-waiting)   
- interrupt   
- DMA   


Blocking I/O vs Non-blocking I/O   

Blocking I/O: thread is suspended   

Non-blocking I/O: 기다리지않고 바로 실행됨   

Asynchronous(system call)   

Non-blocking 과 Asynchronous 의 차이   
- read() 호출시   
  - Non-blocking:  
      즉시 return   

  - Asynchronous: 
      호출이 비동기적으로 수행
      실제 읽기 작업이 백그라운드에서 수행되어 완료시 콜백 함수나 이벤트를 통해 프로그램에 알림


File System

storage에 data와 프로그램들을 논리적으로 다루는 시스템

Access 방법들   
1. sequential   
2. direct   

directory structure

파일시스템도 사실 여러 레벨로 구현됨   

Allocation 방법

파일들을 넣어둘 공간을 어떻게 할당해줄건가?
효율적으로, 빠르게 접근할 수 있도록

Contiguous: 연속적으로 할당   
Linked: 따로 떨어진 블록들을 서로가 각자 다음 블록을 가리킴   
    영화를 중간부터 보고싶을때 뒷부분을 디스크에서 찾으려면 결국 모든 블록들을 순차적으로 읽을수밖에 없음   
    대표적으로 FAT(File Allocation Table)방식이 있음   
    FAT는 위의 방법에 추가적으로 각 노드들의 인덱스들을 모아놓은 놈이 따로 있음   
Indexed: 한놈이 다른 블록들의 모든 위치를 인덱스로 가짐(인덱스 블록)   
    얘는 FAT가아님 Linked + Indexed 가 FAT인 거임    
    문제는 하드디스크에 bad sector가 발생하는 경우를 방지하기 위해 만들어짐   

인덱스 블록을 이용해서 과학수사대의 포렌식 전문가가 범죄자들 하드디스크 복구하는 거임   

Allocation 했으면 free 하는것도 해야지   
Free-Space Management   

free space들을 Linked list로 관리   

FILE

UNIX 에서의 FILE 이란?   
연속된 binary 집합    


