package com.bakigoal.webfluxmongo.rest

import com.bakigoal.webfluxmongo.model.Account
import com.bakigoal.webfluxmongo.repo.AccountReactiveRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/v1/account")
class AccountController(@Autowired val accountReactiveRepo: AccountReactiveRepo) {

    @GetMapping
    fun getAll(): Flux<Account> = accountReactiveRepo.findAll()

    @PostMapping
    fun create(@RequestBody account: Account): Mono<Account> = accountReactiveRepo.save(account)

    @PutMapping("/{id}")
    fun update(@PathVariable id: String, @RequestBody account: Account): Mono<Account> {
        account.id = id
        return accountReactiveRepo.save(account)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: String): Mono<Account> =
        accountReactiveRepo.findById(id)
            .doOnNext { accountReactiveRepo.delete(it).subscribe() }

}