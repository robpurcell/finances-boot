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
package com.robbyp.finances.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

@Data
public class Account {

  @Id
  @Setter(AccessLevel.NONE) private String id;

  @NonNull @Setter(AccessLevel.NONE) private String name;
  @NonNull @Setter(AccessLevel.NONE) private String number;
  @NonNull @Setter(AccessLevel.NONE) private String institution;
  @NonNull @Setter(AccessLevel.NONE) private BigDecimal openingBalance;

  @Override
  public String toString() {
    return String.format(
      "Account[id=%s, name='%s', number='%s', institution='%s]",
      id, name, number, institution);
  }

}
