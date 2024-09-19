<template>
  <div class="main-container w-[393px] h-[1285px] bg-[#f3f4f6] relative mx-auto my-0">
    <div class="flex flex-col items-center w-full h-full p-4 gap-5 bg-[#f3f4f6]">
      <div class="w-full max-w-[393px] rounded-lg p-4">
        <!-- Settings Section -->
        <div class="flex flex-col items-start bg-[#fff] rounded-lg p-3">
          <div class="flex items-center w-full h-[32px] mb-4 justify-between">
            <div class="flex items-center">
              <div class="w-[32px] h-[32px] flex items-center justify-center">
                <img src="../assets/all/total.png" class="w-[30px] h-[24px]" alt="Icon">
              </div>
              <span class="text-[20px] font-bold text-[#000] ml-2">설정</span>
            </div>
          </div>
          <!-- Settings Items -->
          <RouterLink to="/asset">
            <div class="flex items-center justify-between h-[25px] px-4 mb-2 cursor-pointer">
              <span class="text-[12px] font-bold text-[#000] w-[75px]">간편비밀번호</span>
              <svg class="w-[380px] h-[20px] text-[#1d0c0c] rotate-[-90deg]" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M19 11l-6 6-6-6" />
              </svg>
            </div>
          </RouterLink>
          <RouterLink to="/asset">
            <div class="flex items-center justify-between h-[25px] px-4 mb-2 cursor-pointer">
              <span class="text-[12px] font-bold text-[#000] w-[85px]">회원 정보 수정</span>
              <svg class="w-[360px] h-[20px] text-[#1d0c0c] rotate-[-90deg]" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M19 11l-6 6-6-6" />
              </svg>
            </div>
          </RouterLink>
          <RouterLink to="/asset">
            <div class="flex items-center justify-between h-[25px] px-4 mb-2 cursor-pointer">
              <span class="text-[12px] font-bold text-[#000] w-[75px]">용돈 확인</span>
              <svg class="w-[380px] h-[20px] text-[#1d0c0c] rotate-[-90deg]" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M19 11l-6 6-6-6" />
              </svg>
            </div>
          </RouterLink>
          <RouterLink to="/asset">
            <div class="flex items-center justify-between h-[25px] px-4 mb-2 cursor-pointer">
              <span class="text-[12px] font-bold text-[#000] w-[75px]">입금계좌등록</span>
              <svg class="w-[380px] h-[20px] text-[#1d0c0c] rotate-[-90deg]" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M19 11l-6 6-6-6" />
              </svg>
            </div>
          </RouterLink>
        </div>

        <!-- Family Management Section -->
        <div class="flex flex-col items-start bg-[#fff] rounded-lg p-3 mt-4">
          <div class="flex items-center w-full h-[32px] mb-4 justify-between">
            <div class="flex items-center">
              <div class="w-[32px] h-[32px] flex items-center justify-center">
                <img src="../assets/all/total.png" class="w-[30px] h-[24px]" alt="Icon">
              </div>
              <span class="text-[20px] font-bold text-[#000] ml-2 w-[100px]">가족관리</span>
            </div>
          </div>
          <!-- Family Management Items -->
          <RouterLink to="/asset">
            <div class="flex items-center justify-between h-[25px] px-4 mb-2 cursor-pointer">
              <span class="text-[12px] font-bold text-[#000] w-[75px]">내 가족</span>
              <svg class="w-[380px] h-[20px] text-[#1d0c0c] rotate-[-90deg]" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M19 11l-6 6-6-6" />
              </svg>
            </div>
          </RouterLink>
          <RouterLink to="/asset">
            <div class="flex items-center justify-between h-[25px] px-4 mb-2 cursor-pointer">
              <span class="text-[12px] font-bold text-[#000] w-[75px]">가족 연결</span>
              <svg class="w-[380px] h-[20px] text-[#1d0c0c] rotate-[-90deg]" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M19 11l-6 6-6-6" />
              </svg>
            </div>
          </RouterLink>
        </div>

        <!-- Asset Section -->
        <div class="flex flex-col items-start bg-[#fff] rounded-lg p-3 mt-4">
          <div class="flex items-center w-full h-[32px] mb-4 justify-between">
            <div class="flex items-center">
              <div class="w-[32px] h-[32px] flex items-center justify-center">
                <img src="../assets/all/total.png" class="w-[30px] h-[24px]" alt="Icon">
              </div>
              <span class="text-[20px] font-bold text-[#000] ml-2">자산</span>
            </div>
          </div>
          <!-- Asset Items -->
          <RouterLink to="/asset">
            <div class="flex items-center justify-between h-[25px] px-4 mb-2 cursor-pointer">
              <span class="text-[12px] font-bold text-[#000] w-[75px]">자산</span>
              <svg class="w-[380px] h-[20px] text-[#1d0c0c] rotate-[-90deg]" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M19 11l-6 6-6-6" />
              </svg>
            </div>
          </RouterLink>
          <RouterLink to="/asset">
            <div class="flex items-center justify-between h-[25px] px-4 mb-2 cursor-pointer">
              <span class="text-[12px] font-bold text-[#000] w-[75px]">출금 요청</span>
              <svg class="w-[380px] h-[20px] text-[#1d0c0c] rotate-[-90deg]" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M19 11l-6 6-6-6" />
              </svg>
            </div>
          </RouterLink>
        </div>

        <!-- Finance Section -->
        <div class="flex flex-col items-start bg-[#fff] rounded-lg p-3 mt-4">
          <div class="flex items-center w-full h-[32px] mb-4 justify-between">
            <div class="flex items-center">
              <div class="w-[32px] h-[32px] flex items-center justify-center">
                <img src="../assets/all/total.png" class="w-[30px] h-[24px]" alt="Icon">
              </div>
              <span class="text-[20px] font-bold text-[#000] ml-2">금융</span>
            </div>
          </div>
          <!-- Finance Items -->
          <RouterLink to="/asset">
            <div class="flex items-center justify-between h-[25px] px-4 mb-2 cursor-pointer">
              <span class="text-[12px] font-bold text-[#000] w-[75px]">자산 관리</span>
              <svg class="w-[380px] h-[20px] text-[#1d0c0c] rotate-[-90deg]" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M19 11l-6 6-6-6" />
              </svg>
            </div>
          </RouterLink>
          <RouterLink to="/asset">
            <div class="flex items-center justify-between h-[25px] px-4 mb-2 cursor-pointer">
              <span class="text-[12px] font-bold text-[#000] w-[75px]">부채 관리</span>
              <svg class="w-[380px] h-[20px] text-[#1d0c0c] rotate-[-90deg]" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M19 11l-6 6-6-6" />
              </svg>
            </div>
          </RouterLink>
        </div>

        <!-- Transaction Section -->
        <div class="flex flex-col items-start bg-[#fff] rounded-lg p-3 mt-4">
          <div class="flex items-center w-full h-[32px] mb-4 justify-between">
            <div class="flex items-center">
              <div class="w-[32px] h-[32px] flex items-center justify-center">
                <img src="../assets/all/total.png" class="w-[30px] h-[24px]" alt="Icon">
              </div>
              <span class="text-[20px] font-bold text-[#000] ml-2">거래내역</span>
            </div>
          </div>
          <!-- Transaction Items -->
          <RouterLink to="/asset">
            <div class="flex items-center justify-between h-[25px] px-4 mb-2 cursor-pointer">
              <span class="text-[12px] font-bold text-[#000] w-[75px]">입금내역</span>
              <svg class="w-[380px] h-[20px] text-[#1d0c0c] rotate-[-90deg]" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M19 11l-6 6-6-6" />
              </svg>
            </div>
          </RouterLink>
          <RouterLink to="/asset">
            <div class="flex items-center justify-between h-[25px] px-4 mb-2 cursor-pointer">
              <span class="text-[12px] font-bold text-[#000] w-[75px]">출금내역</span>
              <svg class="w-[380px] h-[20px] text-[#1d0c0c] rotate-[-90deg]" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M19 11l-6 6-6-6" />
              </svg>
            </div>
          </RouterLink>
        </div>

      <!-- Logout Section -->
      <RouterLink to="/logout">
        <div class="relative w-[145px] h-[33px] mt-[150px] mx-auto">
          <span class="flex w-[120px] h-[33px] justify-center items-center font-['D2Coding'] text-[16px] font-bold leading-[17px] text-[#000] tracking-[-0.3px] absolute top-0 left-0 text-center z-[71]">로그아웃</span>
          <div class="w-[25%] h-[109%] bg-[url(../assets/all/logout.png)] bg-[length:100%_100%] bg-no-repeat absolute top-[-3%] left-[70%] z-[70]"></div>
        </div>
      </RouterLink>

      </div>


    </div>
  </div>
</template>

<script>
import { RouterLink } from 'vue-router';

export default {
  components: {
    RouterLink
  }
};
</script>
