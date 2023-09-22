package com.szn.domain.mappers

import com.szn.domain.model.User
import com.szn.movies.network.model.user.Account

class NetworkUserMapper {

    companion object {
        fun toDomainUser(networkUser: Account): User {
            return User(
                id = networkUser.id,
                username = networkUser.username,
                email = networkUser.username.toString(),
                name = networkUser.username.toString()
            )
        }

        fun fromDomainUser(domainUser: User): Account {
            return Account(
                id = domainUser.id,
                username = domainUser.username,
                name = domainUser.name,
            )
        }
    }
}
