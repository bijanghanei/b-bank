package com.bijanghanei.walletservice;

import com.bijanghanei.walletservice.controller.WalletController;
import com.bijanghanei.walletservice.entity.Wallet;
import com.bijanghanei.walletservice.repository.WalletRepository;
import com.bijanghanei.walletservice.service.WalletService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureMockMvc
class WalletServiceApplicationTests {

	private WalletService walletService = Mockito.mock(WalletService.class);
	private WalletRepository walletRepository = Mockito.mock(WalletRepository.class);
	private WalletController walletController = Mockito.mock(WalletController.class);


	@Test
	void shouldGetWallet() {
		Wallet wallet = new Wallet(123,10);
//		Mockito.when(walletService.findWalletById(1));
		walletRepository.save(wallet);
        Assertions.assertEquals(wallet, walletService.findWalletById(123));
	}

}
