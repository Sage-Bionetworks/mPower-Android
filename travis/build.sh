#!/bin/bash
set -ex
if [[ "$TRAVIS_PULL_REQUEST" != "false" ]]; then     # pull request
    bundle exec fastlane test
elif [[ -z "$TRAVIS_TAG" && "$TRAVIS_BRANCH" == "master" ]]; then  # non-tag commits to master branch
    bundle exec fastlane test
    bundle exec fastlane assemble
elif [[ -z "$TRAVIS_TAG" && "$TRAVIS_BRANCH" =~ ^stable-.* ]]; then # non-tag commits to stable branches
    openssl aes-256-cbc -K $encrypted_d4d8881fb4c9_key -iv $encrypted_d4d8881fb4c9_iv -in travis.json.enc -out travis.json -d
    openssl aes-256-cbc -K $encrypted_d4d8881fb4c9_key -iv $encrypted_d4d8881fb4c9_iv -in sagebio.jks.enc -out sagebio.jks -d
    bundle exec fastlane test
    bundle exec fastlane alpha alias:"$ANDROID_KEY_ALIAS" storepass:"$ANDROID_KEYSTORE_PASSWORD" keypass:"$ANDROID_KEY_PASSWORD" signed_apk_path:"app/build/outputs/apk/app-release.apk"
fi
exit $?
