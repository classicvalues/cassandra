/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.cassandra.rocksdb;

import java.io.File;
import java.util.UUID;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import org.apache.cassandra.cql3.CQLTester;
import org.apache.cassandra.io.util.FileUtils;

public class RocksdbCqlTest extends CQLTester
{
    @BeforeClass
    public static void classSetUp() throws Exception
    {
        String dbdir = "/tmp/rocksdbtest/" + UUID.randomUUID();
        System.setProperty("cassandra.rocksdb.keyspace", CQLTester.KEYSPACE);
        System.setProperty("cassandra.rocksdb.dir", dbdir);
        File rocksdbdir = new File(dbdir);
        if (rocksdbdir.exists())
        {
            FileUtils.deleteRecursive(rocksdbdir);
        }
    }

    @AfterClass
    public static void classTeardown() throws Exception
    {
        System.clearProperty("cassandra.rocksdb.keyspace");
        System.clearProperty("cassandra.rocksdb.dir");
    }
}
