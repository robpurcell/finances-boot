// Copyright 2017 Purcell Informatics Limited
//
// See the LICENCE file distributed with this work for additional
// information regarding copyright ownership.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
package com.robbyp.finances;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.robbyp.finances.data.TransactionRepository;
import com.robbyp.finances.domain.Person;
import com.robbyp.finances.domain.Transaction;

@Component
public class TransactionDataRunner implements CommandLineRunner {

  private final ApplicationContext ctx;

  private final TransactionRepository repository;

  @Autowired
  public TransactionDataRunner(ApplicationContext context, TransactionRepository repository) {
    this.ctx = context;
    this.repository = repository;
  }

  public void run(String... args) throws Exception {
    repository.deleteAll();
    repository.insert(new Transaction(LocalDate.now(),
                                      "Descr",
                                      "Amazon",
                                      new Person("Rob"),
                                      BigDecimal.valueOf(100))
    );
  }

}
