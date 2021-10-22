package com.example.Thanks.Bonus.Controllers;


import com.example.Thanks.Bonus.domain.bankInfo;
import com.example.Thanks.Bonus.repository.bankInfoRepo;
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

import java.util.List;

@RestController
@RequestMapping("bank")
public class Controller {
	private final bankInfoRepo bankInfoRepo;

	@Autowired
	public Controller(bankInfoRepo bankInfoRepo) {
		this.bankInfoRepo = bankInfoRepo;
	}

	@GetMapping
	public List<bankInfo> list(){
		return bankInfoRepo.findAll();
	}

	@GetMapping("{id}")
	public bankInfo getOne(@PathVariable("id") bankInfo bankInfo) {
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
	public bankInfo create(@RequestBody bankInfo bankInfo) {
		return bankInfoRepo.save(bankInfo);
	}

	@PutMapping("{id}")
	public bankInfo update(
			@PathVariable("id") bankInfo bankInfoFromDb,
			@RequestBody bankInfo bankInfo
	) {
		BeanUtils.copyProperties(bankInfo, bankInfoFromDb, "id");
		return bankInfoRepo.save(bankInfoFromDb);
	}

	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") bankInfo bankInfo) {
		bankInfoRepo.delete(bankInfo);
	}
}
