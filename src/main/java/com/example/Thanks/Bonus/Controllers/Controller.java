package com.example.Thanks.Bonus.Controllers;


import com.example.Thanks.Bonus.domain.BankInfo;
import com.example.Thanks.Bonus.repository.BankInfoRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("bankInfo")
public class Controller {
	private final BankInfoRepo bankInfoRepo;

	@Autowired
	public Controller(BankInfoRepo bankInfoRepo) {
		this.bankInfoRepo = bankInfoRepo;
	}

	@GetMapping
	public List<BankInfo> list(){
		return bankInfoRepo.findAll();
	}

	@GetMapping("{id}")
	public BankInfo getOne(@PathVariable("id") BankInfo bankInfo) {
		return bankInfo;
	}

/*	private Map<String, String> getIndex(@PathVariable String id) {
		return index.stream()
				.filter(index -> index.get("id").equals(id))
				.findFirst()
				.orElseThrow(NotFoundException::new);
	}
*/
	@PostMapping
	public BankInfo create(@RequestBody BankInfo bankInfo) {
		bankInfo.setDateTime(LocalDateTime.now());
		return bankInfoRepo.save(bankInfo);
	}

	@PutMapping("{id}")
	public BankInfo update(
			@PathVariable("id") BankInfo bankInfoFromDb,
			@RequestBody BankInfo bankInfo
	) {
		BeanUtils.copyProperties(bankInfo, bankInfoFromDb, "id");
		return bankInfoRepo.save(bankInfoFromDb);
	}

	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") BankInfo bankInfo) {
		bankInfoRepo.delete(bankInfo);
	}
}
