/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache license, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the license for the specific language governing permissions and
 * limitations under the license.
 */

package widget.trouble

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.unit.sp
import module.TroubleEnum
import widget.component.RowPaddingButton
import widget.trouble.nginx.TroubleNginx
import widget.trouble.zookeeper.TroubleZooKeeper

val idx = mutableStateOf(TroubleEnum.Nginx)

@Composable
fun TroubleShootScreen() {
    Column {
        Head(idx)
        when (idx.value) {
            TroubleEnum.Nginx -> {
                TroubleNginx()
            }
            TroubleEnum.ZooKeeper -> {
                TroubleZooKeeper()
            }
        }
    }
}

@Composable
fun Head(idx: MutableState<TroubleEnum>) {
    Row {
        Text(R.strings.TroubleComponent, fontSize = 40.sp)
        RowPaddingButton(
            onClick = {
                idx.value = TroubleEnum.Nginx
            },
        ) {
            Text(text = "Nginx")
        }
        RowPaddingButton(
            onClick = {
                idx.value = TroubleEnum.ZooKeeper
            },
        ) {
            Text(text = "ZooKeeper")
        }
    }
}
